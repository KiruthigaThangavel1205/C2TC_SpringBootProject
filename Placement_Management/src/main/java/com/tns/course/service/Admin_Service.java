//This program to define Course Service class for managing Course entities.
package com.tns.course.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.tns.course.entity.Admin_Course;
import com.tns.course.exception.Admin_ServiceException;
import com.tns.course.repository.Admin_Repository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
public class Admin_Service implements Admin_ICourseService{

	@Autowired
	private final Admin_Repository courseRepository;
	
	//Constructor injection for CourseRepository dependency.
    public Admin_Service(Admin_Repository courseRepository) {
        this.courseRepository = courseRepository;
    }
    
    //Retrieves all courses from the database.
    public List<Admin_Course> getAllCourses()throws Admin_ServiceException 
    {
            return courseRepository.findAll();  
    }

    //Retrieves a course by its ID.
    public Optional<Admin_Course> getCourseById(Long id)throws Admin_ServiceException 
    {
            return courseRepository.findById(id);
     }
    
    //Retrieves a courses by its id
    public List<Admin_Course> getCoursesByIdLessThan(long id)throws Admin_ServiceException 
    {
        return courseRepository.retrieveByIdLessThan(id);
    }    
    //Retrieves a course by its title
    public List<Admin_Course> getCourse(String title)throws Admin_ServiceException 
    {
		return courseRepository.findByTitle(title);
	}
    
    //Retrieves a courses by instructor
    public List<Admin_Course> getCoursesByInstructorIgnoreCase(String instructor)throws Admin_ServiceException 
    {
        return courseRepository.findByInstructorIgnoreCase(instructor);
    }
    //Retrieves a course by its description
    public List<Admin_Course> getCourseByDescription(String description) throws Admin_ServiceException
    {
    	return courseRepository.findByDescription(description);
    }
    //Retrieves a course by its startDate
    public List<Admin_Course> getCourseByStartDate(Date startDate)throws Admin_ServiceException 
    {
        return courseRepository.findByStartDate(startDate);
    }
    //Retrieves a course by its startDate with range
    public List<Admin_Course> getCoursesByStartDateBetween(Date startDateStartOfDay, Date startDateEndOfDay)throws Admin_ServiceException 
    {
        return courseRepository.retrieveByStartDateBetween(startDateStartOfDay, startDateEndOfDay);
    }
    //Retrieves a course by its endDate
    public List<Admin_Course> getCourseByEndDate(Date endDate) throws Admin_ServiceException
    {
        return courseRepository.findByEndDate(endDate);
    }
    //Retrieves a course by its title containing a keyword
    public List<Admin_Course> findByTitleContaining(String keyword) throws Admin_ServiceException
    {
        return courseRepository.findByTitleContaining(keyword);
    }
    //Retrieves a courses by its pagination 
    public Page<Admin_Course> findAll(Pageable pageable) throws Admin_ServiceException
    { 
        return courseRepository.findAll(pageable);
    }
    //Retrieves a courses by its limits in descending order
    @Override
    public List<Admin_Course> findTopNCoursesByEndDate(int n)throws Admin_ServiceException {
       
    	 Pageable pageable = PageRequest.of(0, n);
         return courseRepository.findTopNByOrderByEndDateDesc(pageable);
    }
    //Retrieves a courses by its limits in ascending order
    public List<Admin_Course> findAllCoursesOrderByStartDateAsc()throws Admin_ServiceException 
    {
       
        return courseRepository.findAllByOrderByStartDateAsc();
    }
    // Find courses by instructor and title containing a keyword
    public List<Admin_Course> findByInstructorAndTitleContaining(String instructor, String keyword) throws Admin_ServiceException
    {
        return courseRepository.findByInstructorAndTitleContaining(instructor, keyword);
    }

    // Find courses with pagination and sorting by title
    public Page<Admin_Course> findByTitleContaining(String keyword, Pageable pageable) throws Admin_ServiceException
    {
        return courseRepository.findByTitleContaining(keyword, pageable);
    }

    // Count courses by instructor
    public long countByInstructor(String instructor) throws Admin_ServiceException
    {
        return courseRepository.countByInstructor(instructor);
    }
    //Creates a new course.
    public Admin_Course createCourse(Admin_Course course)throws Admin_ServiceException 
    {
            return courseRepository.save(course);
    }

    //Deletes a course by its ID.
    public void deleteCourse(Long id)throws Admin_ServiceException 
    {
            courseRepository.deleteById(id);
    }

    //Updates a course with the given ID.
    public Optional<Admin_Course> updateCourse(Long id, Admin_Course updatedCourse)throws Admin_ServiceException 
    {
            Optional<Admin_Course> optionalCourse = courseRepository.findById(id);
            if (optionalCourse.isPresent()) {
                Admin_Course course = optionalCourse.get();
                // Update course attributes
                course.setTitle(updatedCourse.getTitle());
                course.setDescription(updatedCourse.getDescription());
                course.setStartDate(updatedCourse.getStartDate());
                course.setEndDate(updatedCourse.getEndDate());
                course.setInstructor(updatedCourse.getInstructor());
                // Save the updated course
                return Optional.of(courseRepository.save(course));
            } else {
                return Optional.empty(); // Course with the given ID not found
            }   
    }
}
