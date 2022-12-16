package org.horizonefele.dao;


import org.horizonefele.entities.Team;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TeamRepository extends JpaRepository<Team, Long> {
	@Query("select t from Team t where t.name like :x")
	public Page<Team> findByName(@Param("x")String mc, Pageable pg);
}

