/**
 * @TODO tratar que los controller nunca usen entities
 */

package com.tkksys.backendninja.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tkksys.backendninja.entity.Course;
import com.tkksys.backendninja.service.CourseService;

@Controller
@RequestMapping("/course")
public class CourseController {
	private static final String COURSES_VIEW = "courses";
	
	private static final Log LOG = LogFactory.getLog(CourseController.class); 
	
	@Autowired
	@Qualifier("courseServiceImpl")
	private CourseService courseService;

	@GetMapping("/listcourses")
	public ModelAndView listAllCourses() {
		LOG.info("Call: " + "listcourses()");
		ModelAndView mav = new ModelAndView(COURSES_VIEW);
		mav.addObject("course", new Course());
		mav.addObject("courses", courseService.listAllCourses());
		return mav;
	}
	
	@PostMapping("/addcourse")
	public String addCourse(@ModelAttribute("course") Course course) {
		LOG.info("Call: " + "addcourse() " + " -- Param:" + course.toString());
		courseService.addCouse(course);
		return "redirect:/course/listcourses";
	}
}