package com.fortinet.fortinac.demo.device.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fortinet.fortinac.demo.device.domain.Device;
import com.fortinet.fortinac.demo.device.service.DeviceService;

@RestController
@RequestMapping("/api/device")
@CrossOrigin(origins = "*")
public class DeviceController {	
	@Autowired
	private DeviceService deviceService;

	@RequestMapping("/detail/{id}")
	public Device detail(@PathVariable("id") Long id) {
		return deviceService.getDeviceById(id);
	}

	@RequestMapping("/list")
	public List<Device> list() {
		return deviceService.listDevices();
	}
	
    @RequestMapping(value="/insert", method=RequestMethod.POST, produces="application/json")
	public Device insert(@RequestBody Device device) {
		deviceService.insertDevice(device);
		
		return device;
	}
	
    @RequestMapping(value="/update", method=RequestMethod.POST, produces="application/json")
	public boolean update(@RequestBody Device device) {
		deviceService.updateDevice(device);
		
		return true;
	}
	
    @RequestMapping(value="/delete", method=RequestMethod.POST, produces="application/json")
	public boolean delete(@PathVariable("id") Long id) {
		deviceService.deleteDevice(id);
		
		return true;
	}
}
