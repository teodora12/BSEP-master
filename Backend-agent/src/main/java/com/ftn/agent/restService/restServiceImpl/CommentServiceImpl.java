package com.ftn.agent.restService.restServiceImpl;

import com.ftn.agent.model.TComment;
import com.ftn.agent.repository.CommentRepository;
import com.ftn.agent.restService.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public List<TComment> saveAll(List<TComment> tComments) {
        return this.commentRepository.saveAll(tComments);
    }
}
