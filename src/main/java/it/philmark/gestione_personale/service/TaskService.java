package it.philmark.gestione_personale.service;

import it.philmark.gestione_personale.dto.MessageDto;
import it.philmark.gestione_personale.dto.TaskDto;
import it.philmark.gestione_personale.model.Task;
import it.philmark.gestione_personale.model.User;

import java.util.List;

public interface TaskService {
    public TaskDto findById(Long id);

    public List<TaskDto> findAll();

    public MessageDto insert(TaskDto taskDto);

    public void edit(TaskDto taskDto);
}
