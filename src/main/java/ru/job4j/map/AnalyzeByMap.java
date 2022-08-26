package ru.job4j.map;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        int score = 0;
        int count = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                score += subject.score();
            }
            count += pupil.subjects().size();
        }
        return (count > 0) ? (double) score / count : 0D;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> labels = new ArrayList<>();
        int score;
        for (Pupil pupil : pupils) {
            score = 0;
            for (Subject subject : pupil.subjects()) {
                score += subject.score();
            }
            if (pupil.subjects().size() > 0) {
                labels.add(new Label(pupil.name(), (double) score / pupil.subjects().size()));
            } else {
                labels.add(new Label(pupil.name(), 0D));
            }
        }
        return labels;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        List<Label> labels = new ArrayList<>();
        Map<String, Integer> map = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                map.merge(subject.name(), subject.score(), Integer::sum);
            }
        }
        for (String key : map.keySet()) {
            labels.add(new Label(key, (double) map.get(key) / pupils.size()));
        }
        return labels;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> labels = new ArrayList<>();
        int score;
        for (Pupil pupil : pupils) {
            score = 0;
            for (Subject subject : pupil.subjects()) {
                score += subject.score();
            }
            labels.add(new Label(pupil.name(), score));
        }
        labels.sort(Comparator.naturalOrder());
        return labels.get(labels.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        List<Label> labels = new ArrayList<>();
        Map<String, Integer> map = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                map.merge(subject.name(), subject.score(), Integer::sum);
            }
        }
        for (String key : map.keySet()) {
            labels.add(new Label(key, map.get(key)));
        }
        labels.sort(Comparator.naturalOrder());
        return labels.get(labels.size() - 1);
    }
}