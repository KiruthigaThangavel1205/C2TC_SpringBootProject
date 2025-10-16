//This program to define Course Service Interface 
package com.tns.course.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.tns.course.entity.Admin_Course;
import com.tns.course.exception.Admin_ServiceException;

public interface Admin_ICourseService 
{
	 public List<Admin_Course> getAllCourses()throws Admin_ServiceException;

	 public Optional<Admin_Course> getCourseById(Long id)throws Admin_ServiceException;
	 
	 public Admin_Course createCourse(Admin_Course course)throws Admin_ServiceException;
	 
	 public void deleteCourse(Long id)throws Admin_ServiceException;
	 
	 public Optional<Admin_Course> updateCourse(Long id, Admin_Course updatedCourse)throws Admin_ServiceException;
	 
	 public List<Admin_Course> getCoursesByIdLessThan(long id)throws Admin_ServiceException;
	 
	 public List<Admin_Course> getCourse(String title)throws Admin_ServiceException;
	 
	 public List<Admin_Course> getCoursesByInstructorIgnoreCase(String instructor)throws Admin_ServiceException;
	 
	 public List<Admin_Course> getCourseByDescription(String description) throws Admin_ServiceException;
	 
	 public List<Admin_Course> getCourseByStartDate(Date startDate)throws Admin_ServiceException;
	 
	 public List<Admin_Course> getCoursesByStartDateBetween(Date startDateStartOfDay, Date startDateEndOfDay)throws Admin_ServiceException;
	 
	 public List<Admin_Course> getCourseByEndDate(Date endDate) throws Admin_ServiceException;
	 
	 public List<Admin_Course> findByTitleContaining(String keyword)throws Admin_ServiceException;
	 
	 public Page<Admin_Course> findAll(Pageable pageable)throws Admin_ServiceException;
	 
     public List<Admin_Course> findTopNCoursesByEndDate(int n)throws Admin_ServiceException;
	       
	 public List<Admin_Course> findAllCoursesOrderByStartDateAsc()throws Admin_ServiceException;
	 
	 public List<Admin_Course> findByInstructorAndTitleContaining(String instructor, String keyword)throws Admin_ServiceException;
	 
	 public Page<Admin_Course> findByTitleContaining(String keyword, Pageable pageable)throws Admin_ServiceException;

	 public long countByInstructor(String instructor)throws Admin_ServiceException;
}
