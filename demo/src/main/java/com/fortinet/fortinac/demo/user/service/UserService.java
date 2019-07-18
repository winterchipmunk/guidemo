package com.fortinet.fortinac.demo.user.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

import com.fortinet.fortinac.demo.exception.FortiException;
import com.fortinet.fortinac.demo.user.domain.User;

@Component
public class UserService {
	private final AtomicLong counter = new AtomicLong(1);
	private List<User> listUsers;

	@PostConstruct
	public void init() {
		listUsers = new ArrayList<User>();
		
		for( long id = 0; id< 10; id++ )
			listUsers.add(this.generateUserById(counter.addAndGet(1)));		
	}
	
	public User getUserById(long id) {
		Iterator<User> it = listUsers.iterator();
		
		User user;
		while( it.hasNext() ) {
			user = it.next();
			
			if( user.getId() == id ) {
				return user;
			}
		}
		
		return null;
	}
	
	public List<User> listUsers() {
		return listUsers;
	}
	
	public long insertUser(User user) {
		user.setId(counter.addAndGet(1));
		
		return user.getId();
	}
	
	public void updateUser(User user) {
		for( int i=0; i<listUsers.size(); i++ ) {
			User userOld = listUsers.get(i);
			
			if( userOld.getId() == user.getId() ) {
				listUsers.set(i, user);
				return;
			}
		}
		
		throw new FortiException("errors.dao.notfound");
	}
	
	public void deleteUser(long id) {
		Iterator<User> it = listUsers.iterator();
		
		User user;
		while( it.hasNext() ) {
			user = it.next();
			
			if( user.getId() == id ) {
				it.remove();
			}
		}
		
		throw new FortiException("errors.dao.notfound");
	}
	
	private User generateUserById(long id) {
		return new User(id, "user" + id, new Date(), null);
	}
	
	@PreDestroy
	public void destroy() {
	}
}
