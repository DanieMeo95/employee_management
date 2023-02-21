package it.philmark.gestione_personale.service.serviceImpl;

import it.philmark.gestione_personale.dto.MessageDto;
import it.philmark.gestione_personale.dto.TaskDto;
import it.philmark.gestione_personale.exception.EmployeeManagementException;
import it.philmark.gestione_personale.exception.Messages;
import it.philmark.gestione_personale.mapper.TaskMapper;
import it.philmark.gestione_personale.model.Task;
import it.philmark.gestione_personale.repository.TaskRepository;
import it.philmark.gestione_personale.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private TaskMapper taskMapper;

    @Override
    public TaskDto findById(Long id) {
        return taskMapper.mapEntityToDto(taskRepository.findById(id).orElseThrow(() -> new EmployeeManagementException(Messages.erroreGenerico)));
    }

    @Override
    public List<TaskDto> findAll() {
        return taskMapper.mapEntityToDto(taskRepository.findAll());
    }

    @Override
    public MessageDto insert(TaskDto taskDto) {
        taskRepository.save(taskMapper.mapDtoToEntity(taskDto));
        return new MessageDto(Messages.successInsert, HttpStatus.OK);

    }

    @Override
    public void edit(TaskDto taskDto) {
        taskRepository.save(taskMapper.mapDtoToEntity(taskDto));
    }

}
