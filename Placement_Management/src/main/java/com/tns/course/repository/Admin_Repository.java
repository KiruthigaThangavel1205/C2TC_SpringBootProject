//This program to define Course Repository Interface for Courses entities
package com.tns.course.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tns.course.entity.Admin_Course;

public interface Admin_Repository extends JpaRepository<Admin_Course, Long> {
	
	//Automated Custom Queries
	//Retrieve a course by its title
	List<Admin_Course> findByTitle(String title);
    
    // Retrieve a course by its description
	List<Admin_Course> findByDescription(String description);
    
    // Retrieve a course by its start date
	List<Admin_Course> findByStartDate(Date startDate);
    
    // Retrieve a course by its end date
	List<Admin_Course> findByEndDate(Date endDate);
	
	// Retrieve courses taught by a specific instructor (case-insensitive)
    List<Admin_Course> findByInstructorIgnoreCase(String instructor);
    
    // Retrieve courses by title containing a keyword
    List<Admin_Course> findByTitleContaining(String keyword);
    
    // Retrieve all courses with pagination
    Page<Admin_Course> findAll(Pageable pageable);

    // Custom query to find courses sorted by start date
    List<Admin_Course> findAllByOrderByStartDateAsc();
    
    // Find courses by instructor and title containing a keyword
    List<Admin_Course> findByInstructorAndTitleContaining(String instructor, String keyword);

    // Find courses with pagination and sorting by title
    Page<Admin_Course> findByTitleContaining(String keyword, Pageable pageable);

    // Count courses by instructor
    long countByInstructor(String instructor);
	
	//Manual Custom Queries
    
    // Retrieve courses with an ID less than the provided ID
    @Query("SELECT c FROM Admin_Course c WHERE c.id < :id")
    List<Admin_Course> retrieveByIdLessThan(@Param("id") long id);
     
    // Retrieve courses with start date between the provided start and end dates
    @Query("SELECT c FROM Admin_Course c WHERE c.startDate BETWEEN :startDateStartOfDay AND :endDateEndOfDay")
    List<Admin_Course> retrieveByStartDateBetween(
            @Param("startDateStartOfDay") Date startDateStartOfDay,
            @Param("endDateEndOfDay") Date endDateEndOfDay);

    //Retrieve top N courses by end date 
    @Query("SELECT c FROM Admin_Course c ORDER BY c.endDate DESC")
    List<Admin_Course> findTopNByOrderByEndDateDesc(Pageable pageable);
    
}
