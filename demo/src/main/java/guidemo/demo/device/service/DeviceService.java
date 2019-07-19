package guidemo.demo.device.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

import guidemo.demo.device.domain.Device;
import guidemo.demo.exception.FortiException;

@Component
public class DeviceService {
	private final AtomicLong counter = new AtomicLong(1);
	private List<Device> listDevices;

	@PostConstruct
	public void init() {
		listDevices = new ArrayList<Device>();
		
		for( long id = 0; id< 10; id++ )
			listDevices.add(this.generateDeivceById(counter.addAndGet(1)));		
	}
	
	public Device getDeviceById(long id) {
		Iterator<Device> it = listDevices.iterator();
		
		Device device;
		while( it.hasNext() ) {
			device = it.next();
			
			if( device.getId() == id ) {
				return device;
			}
		}
		
		return null;
	}
	
	public List<Device> listDevices() {
		return listDevices;
	}
	
	public long insertDevice(Device device) {
		device.setId(counter.addAndGet(1));
		
		return device.getId();
	}
	
	public void updateDevice(Device device) {
		for( int i=0; i<listDevices.size(); i++ ) {
			Device deviceOld = listDevices.get(i);
			
			if( deviceOld.getId() == device.getId() ) {
				listDevices.set(i, device);
				return;
			}
		}
		
		throw new FortiException("errors.dao.notfound");
	}
	
	public void deleteDevice(long id) {
		Iterator<Device> it = listDevices.iterator();
		
		Device device;
		while( it.hasNext() ) {
			device = it.next();
			
			if( device.getId() == id ) {
				it.remove();
			}
		}
		
		throw new FortiException("errors.dao.notfound");
	}
	
	private Device generateDeivceById(long id) {
		return new Device(id, "device" + id, "172.22.13.10");
	}
	
	@PreDestroy
	public void destroy() {
	}
}
