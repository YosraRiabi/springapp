package com.riabi.springapp.controller;

import com.riabi.springapp.domain.Link;
import com.riabi.springapp.domain.Vote;
import com.riabi.springapp.repository.LinkRepository;
import com.riabi.springapp.repository.VoteRepository;
import com.riabi.springapp.service.VoteService;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class VoteController {

    private VoteService voteService;
    private LinkRepository linkRepository;

    public VoteController(VoteService voteService, LinkRepository linkRepository) {
        this.voteService = voteService;
        this.linkRepository = linkRepository;
    }

    //http://localhost:8080/vote/link/1/direction/-1/votecount/5
    @Secured({"ROLE_USER"})
    @GetMapping("/vote/link/{linkID}/direction/{direction}/votecount/{voteCount}")
    public int vote(@PathVariable Long linkID, @PathVariable short direction, @PathVariable int voteCount) {

        Optional<Link> optionalLink = linkRepository.findById(linkID);
        if (optionalLink.isPresent()) {
            Link link = optionalLink.get();
            Vote vote = new Vote(direction, link);
            voteService.save(vote);

            int updatedVoteCount = voteCount + direction;
            link.setVoteCount(updatedVoteCount);
            linkRepository.save(link);
            return updatedVoteCount;

        }
        return voteCount;
    }
}
