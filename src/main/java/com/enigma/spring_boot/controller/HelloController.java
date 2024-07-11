package com.enigma.spring_boot.controller;

import com.enigma.spring_boot.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HelloController {
    //	@RestController, @Controller
    // cara lama mebuat request mapping
    // resources atau enpoint (api/hello)
    // http://localhost:8080/api/hello
    //@RequestMapping(method = RequestMethod.GET, value = "/api/hello")
    @GetMapping("/api/hello")
    public Object hello() {
        // java > 8
        // anonymous object
		/*return new Object(){
			private String name = "Spring Boot jancok";
			public String getName() {
				return name;
			}
		};*/
        Map<String, Object> person = new HashMap<>();
        Map<String, Object> address = new HashMap<>();
        address.put("dusun", "gondosari");
        address.put("rt/rw", "003/011");
        address.put("regency","solotigo");
        person.put("name", "budi");
        person.put("age", 22);
        person.put("gender", "male");
        person.put("address", address);
        return person;
    }

    // path variable untuk mencari data yang spesifik
    @GetMapping("/api/customers/{xxx-id}")
    public Object hello(@PathVariable(name ="xxx-id") Integer id) { // nama paramater harus sama dengan path, misal String idX = customers/{idX} atau
        return "Customer diancok : "+id;
    }

    // request param / query param ==> digunakan untuk filtering data
    @GetMapping("/api/customers")
    public Object getCustomerFilter(@RequestParam(defaultValue = "Bedes") String name, @RequestParam(defaultValue = "898") Integer age) {

        return "customer : "+ name + "<br>" +" age : "+age;
    }

    @PostMapping("/api/customers")
//	biar mudah memahami, anggap saja, parameter itu request dari Client/User melalui @RequestBody, dan return adalah Response daru Server
    public Customer createCustomer(@RequestBody Customer customer) {
        //@RequestBody digunakan untuk mengkonversi JSON menjadi Object(java) agar terbaca,
        // tanpa @RequestBody akan terjadi error

        return customer;
    }
}
