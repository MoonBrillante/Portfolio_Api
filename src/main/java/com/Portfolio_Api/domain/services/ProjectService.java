package com.Portfolio_Api.domain.services;

import com.Portfolio_Api.domain.models.Project;
import com.Portfolio_Api.infra.repositories.ProjectRepository;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@Service
public class ProjectService {
    private final ProjectRepository projectRepository;
    private final Cloudinary cloudinary;

    @Autowired
    public ProjectService(ProjectRepository projectRepository, Cloudinary cloudinary) {
        this.projectRepository = projectRepository;
        this.cloudinary = cloudinary;
    }

    public List<Project> getProject() {
        return projectRepository.findAll();
    }

    public Project projectById(Integer id){
        Optional<Project> projectById = projectRepository.findById(id);
        return projectById.orElse(null);
    }
    public void newProject(String name,String description, String technology,MultipartFile img) throws IOException {
        Map uploadResult = cloudinary.uploader().upload(img.getBytes(), ObjectUtils.emptyMap());
        String imageUrl =(String) uploadResult.get("url");

        Project project = new Project(name,description,technology,imageUrl);
        projectRepository.save(project);
    }


    public void update(Integer id, String name,String description, String technology,MultipartFile img) throws IOException {

        Project projectEncontrado = projectById(id);


        if (projectEncontrado !=null) {

            Map uploadResult = cloudinary.uploader().upload(img.getBytes(),ObjectUtils.emptyMap());
            String imgUrl = (String) uploadResult.get("url");

            projectEncontrado.setName(name);
            projectEncontrado.setDescription(description);
            projectEncontrado.setTechnology(technology);
            projectEncontrado.setImg(imgUrl);

            projectRepository.save(projectEncontrado);
        }
    }
    public void deleteProject(Integer id, Project project){
        boolean existe =projectRepository.existsById(id);
        if (existe){
            projectRepository.delete(project);
        }
    }
}
