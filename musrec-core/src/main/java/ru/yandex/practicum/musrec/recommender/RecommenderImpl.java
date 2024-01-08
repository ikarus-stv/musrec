package ru.yandex.practicum.musrec.recommender;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecommenderImpl implements Recommender {

    DescriptiveStatistics total = new DescriptiveStatistics();
    Map<String, DescriptiveStatistics> statByAuthors = new HashMap<>();

    @Override
    public void addLikedTracks(List<Track> tracks) {
        for (Track track: tracks) {
            total.addValue(track.getMark());
            addTrackToAuthorTracks(track);
        }

    }

    @Override
    public void addLikedTrack(Track track) {
        total.addValue(track.getMark());
        addTrackToAuthorTracks(track);
    }

    private void addTrackToAuthorTracks(Track track) {
        String author = track.getAuthor();
        DescriptiveStatistics statForAuthor;
        if (statByAuthors.containsKey(author)) {
            statForAuthor = statByAuthors.get(track.getAuthor());
        } else {
            statForAuthor = new DescriptiveStatistics();
            statByAuthors.put(author, statForAuthor);
        }
        statForAuthor.addValue(track.getMark());
    }

    @Override
    public double predictMark(Track track) {
        String author = track.getAuthor();
        if (statByAuthors.containsKey(author)) {
            return statByAuthors.get(author).getMean();
        } else {
            return total.getMean();
        }
    }
}
