package com.tkksys.backendninja.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQuery;
import com.tkksys.backendninja.entity.Course;
import com.tkksys.backendninja.entity.QCourse;

@Repository
public class QueryDSLExampleRepo {

	private QCourse qCourse = QCourse.course;
	
	@PersistenceContext
	private EntityManager em;
	
	public Course find(boolean exist) {
		JPAQuery<Course> query = new JPAQuery<Course>(em);
		
		BooleanBuilder predicateBuilder = new BooleanBuilder(qCourse.description.endsWith("OP"));
		
		if(exist) {
			Predicate predicate2 = qCourse.id.eq(23); //where por el id asignado al predicate
			predicateBuilder.and(predicate2); //acoplamos al predicateBuilder con un "and"
		}else {
			Predicate predicate3 = qCourse.name.endsWith("OP");
			predicateBuilder.or(predicate3);//acoplamos al predicateBuilder con un "or"
		}
		return  (Course) query.select(qCourse.name, qCourse.price).from(qCourse).where(predicateBuilder).fetchOne(); //obtenemos un cursocon las columnas name y price que cumplan con el where dinamico
		
		//List<Course> couses = query.select(qCourse).from(qCourse).where(qCourse.hours.between(20, 50)).fetch();
	}
}
