package io.varnonsoft.chat.controllers;

import io.varnonsoft.chat.entities.Comment;
import io.varnonsoft.chat.entities.Post;
import io.varnonsoft.chat.services.TimelineService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin("*")
@RequestMapping("/timeline")
public class TimelineController {

    private final TimelineService timelineService;

    public TimelineController(TimelineService timelineService) {
        this.timelineService = timelineService;
    }

    @GetMapping
    public Mono<List<Post>> getTimeline(@RequestParam("offset") int offset, @RequestParam("size") int size) {
        return timelineService.getFeeds(offset, size);
    }

    @GetMapping("/{postId}")
    public Mono<Post> getPost(@PathVariable("postId") UUID postId) {
        return timelineService.getSpecificPost(postId);
    }

    @GetMapping("/{postId}/comments")
    public Mono<List<Comment>> getComments(@PathVariable("postId") UUID postId) {
        return timelineService.getComments(postId);
    }
}