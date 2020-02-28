package com.ftn.agent.restService;

import com.ftn.agent.model.TComment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommentService {

     List<TComment> saveAll(List<TComment> tComments);
}
