package core.entities;


import core.dto.GameRecordDto;

import javax.persistence.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by tommylii on 04/12/2015.
 */
@Entity
public class GameRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date date;

    private String location;

    @OneToMany(mappedBy = "gameRecord", cascade = CascadeType.ALL)
    private Set<PlayerRecord> playerRecords;

    private String comments;

    public GameRecord(final Date date) {
        this.date = date;
        this.playerRecords = new HashSet<>();
    }

    public GameRecord() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Set<PlayerRecord> getPlayerRecords() {
        return playerRecords;
    }

    public void setPlayerRecords(Set<PlayerRecord> playerRecords) {
        this.playerRecords = playerRecords;
    }

    public GameRecordDto toGameRecordDto() {
        return new GameRecordDto(this.comments,this.date,this.location,this.playerRecords.stream().map
                (PlayerRecord::toPlayerRecordDto).collect(Collectors.toSet()), id);
    }
}
