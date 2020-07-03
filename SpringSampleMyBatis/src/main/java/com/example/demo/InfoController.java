package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller class for screen display and DB information acquisition
 */
@Controller
public class InfoController {

	@Autowired
	CustomerRepository customerRepository;

    /**
     * Function to display the initial screen
     * @return "index" Return index.html
     */
    @RequestMapping(value="/")
    public String index() {
        return "index";
    }

	/**
	 * Function to get customer information from the DB
	 * @param key Primary key to be acquired
	 * @return mav Return customer information corresponding to the primary key
	 */
    @RequestMapping(value="/get")
	public ModelAndView getInformation(@RequestParam("key") String key) {

		int keyNum = Integer.parseInt(key);
		ModelAndView mav = new ModelAndView();

		mav.setViewName("index");
		// Retrieving customer information from the primary key
		Customer customer = customerRepository.selectByPrimaryKey(keyNum);
		mav.addObject("customerInfo", customer);

		return mav;
	}
}
