package com.weightthumb.service.community.board;

import com.weightthumb.service.community.board.model.CommunityRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CommunityService {
    private final CommunityRepository communityRepository;
}
