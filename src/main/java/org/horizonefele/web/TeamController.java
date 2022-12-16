package org.horizonefele.web;



import java.util.Optional;
import org.horizonefele.dao.TeamRepository;
import org.horizonefele.entities.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TeamController {
@Autowired
private TeamRepository teamDao;

@RequestMapping(value="/teams/search")
public String search(Model model, @RequestParam(name="motCle", defaultValue="")String mc, @RequestParam(name="page", defaultValue="0")int page, @RequestParam(name="size", defaultValue="5")int size) {
Page<Team> teams = teamDao.findByName("%"+mc+"%",PageRequest.of(page,size) );
int[] pages = new int[teams.getTotalPages()];
model.addAttribute("teams",teams.getContent());
model.addAttribute("motC",mc);
model.addAttribute("pages", pages);
model.addAttribute("pageCourante", page);
return "myTeams"; }

@RequestMapping(value="/teams/delete")
public String delete(Model model,

@RequestParam(name="ref", defaultValue="")Long idTeam,
@RequestParam(name="mc", defaultValue="")String mc) {

teamDao.deleteById(idTeam);
return "redirect:/teams/search?motCle="+mc;

}
@RequestMapping(value="/teams/edit")
public String edit(Model model,

@RequestParam(name="ref", defaultValue="")Long idTeam,
@RequestParam(name="name", defaultValue="")String name,
@RequestParam(name="budget", defaultValue="")Float budget,
@RequestParam(name="edit", defaultValue="")int edit,
@RequestParam(name="mc", defaultValue="")String mc) {
if (edit == 0) {
model.addAttribute("idTeam", idTeam);
model.addAttribute("name", name);
model.addAttribute("budget", budget);
model.addAttribute("motCle", mc);
return "editTeam";
}
else {
Optional<Team> ot = teamDao.findById(idTeam);
Team t = ot.get();
t.setName(name);
t.setBudget(budget);
teamDao.save(t);
return "redirect:/teams/search?motCle="+mc;
} }

}