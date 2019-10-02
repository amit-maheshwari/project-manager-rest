package com.cognizant.learn.projectManager.service.impl;

import com.cognizant.learn.projectManager.exception.DuplicateException;
import com.cognizant.learn.projectManager.model.Project;
import com.cognizant.learn.projectManager.repository.ProjectRepository;
import com.cognizant.learn.projectManager.repository.TaskRepository;
import com.cognizant.learn.projectManager.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Project add(Project project) {
        Project projectExists = projectRepository.findByProjectName(project.getProject());
        if(projectExists != null)
            throw new DuplicateException("project.exists",String.valueOf(project.getProject()));
        return projectRepository.save(project);
    }

    @Override
    public void delete(Long id) {
        projectRepository.deleteById(id);
    }

    @Override
    public List<Project> findAll() {
        List<Project> projectList = projectRepository.findAll();
        //taskRepository.findTotalAndCompletedTaskByProject(1);
        Object[][] countArray = null;
       for(Project p : projectList){
           countArray = taskRepository.findTotalAndCompletedTaskByProject(p.getProjectId());
           p.setTotalTask(((BigInteger) countArray[0][0]).intValue());
           p.setCompletedTask(((BigInteger) countArray[0][1]).intValue());
       }
        return projectList;
    }

    @Override
    public Optional<Project> findById(Long id) {
        return projectRepository.findById(id);
    }

    @Override
    public Optional<Project> update(Project project, Long id) {
        Project projectExists = projectRepository.findByProjectName(project.getProject());
        if(projectExists != null && !projectExists.getProjectId().equals(id))
            throw new DuplicateException("project.exists",String.valueOf(project.getProject()));
        Optional<Project> projectOptional = projectRepository.findById(id);
        if(!projectOptional.isPresent())
            return  projectOptional;
        project.setProjectId(id);
        projectRepository.save(project);
        return Optional.of(project);
    }

}
