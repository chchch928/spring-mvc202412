package com.spring.mvcproject.score.api;

import com.spring.mvcproject.score.entity.Score;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.stream.Collectors;

@RestController // JSON 응답
@RequestMapping("/api/v1/scores")
public class ScoreApiController {

    private Map<Long, Score> scoreStore = new HashMap<>();
    private Long nextId = 1L;

    public ScoreApiController() {
        Score s1 = new Score(nextId++, "김말복", 100, 88, 75);
        Score s2 = new Score(nextId++, "박수포자", 55, 95, 15);
        Score s3 = new Score(nextId++, "김마이클", 4, 100, 40);
        Score s4 = new Score(nextId++,"이절반",50,50,50);

        scoreStore.put(s1.getId(), s1);
        scoreStore.put(s2.getId(), s2);
        scoreStore.put(s3.getId(), s3);
        scoreStore.put(s4.getId(), s4);
    }

    // 성적 정보 조회 (정렬 기준: id, name, average)
    // 예: /api/v1/scores?sort=id
    @GetMapping
    public List<Score> scoreList(@RequestParam(defaultValue = "id") String sort) {
        return scoreStore.values()
                .stream()
                .sorted(getComparator(sort))
                .collect(Collectors.toList());
    }

    // Comparator 선택 메서드
    private Comparator<Score> getComparator(String sort) {
        switch (sort) {
            case "name":
                return Comparator.comparing(Score::getName);
            case "average":
                return Comparator.comparingDouble(Score::averageScore);
            default: // 기본 정렬: id
                return Comparator.comparingLong(Score::getId);
        }
    }
}