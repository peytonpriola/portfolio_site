package com.recommendations;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface RecommendationRepository extends CrudRepository<Recommendation, Long>{

		List<Recommendation> findAll();
}
