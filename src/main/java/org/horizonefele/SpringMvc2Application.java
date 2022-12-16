package org.horizonefele;

import org.horizonefele.dao.TeamRepository;
import org.horizonefele.entities.Team;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringMvc2Application {

	public static void main(String[] args) {
		ApplicationContext ctx =SpringApplication.run(SpringMvc2Application.class, args);
		TeamRepository teamDao = ctx.getBean(TeamRepository.class);
		teamDao.save(new Team("Avenir Sportif de Lala", new Float(45000)));
		teamDao.save(new Team("Club Olympique de Transport", new Float(60000)));
		teamDao.save(new Team("Stir Sportif Jarzouna", new Float(40000)));
		teamDao.save(new Team("Avenir Sportif de La Marsa", new Float(85000)));
		teamDao.save(new Team("Club Africain", new Float(600000)));
		teamDao.save(new Team("Club Athletique de Bizerte", new Float(440000)));
		teamDao.save(new Team("Espoir Sportif de Hammem Sousse", new Float(50000)));
		teamDao.save(new Team("Transport Sportif de Tunis", new Float(60000)));
		teamDao.save(new Team("Espérance Sportive de Tunis", new Float(940000)));
		teamDao.findAll().forEach(t->System.out.println(t.getName())); }
	}


