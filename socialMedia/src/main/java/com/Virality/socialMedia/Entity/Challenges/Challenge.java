package com.Virality.socialMedia.Entity.Challenges;

//import com.Virality.socialMedia.Entity.SocialMedia.HashTag;

import java.util.List;
import java.util.UUID;

public class Challenge {
    private UUID challengeId;
    private String challengeDescription;
    private UUID companyId;
    private List<UUID> participants;
    private List<Rule> rules;
//    private List<HashTag> hashTagId;

    public UUID getChallengeId() {
        return challengeId;
    }

    public void setChallengeId(UUID challengeId) {
        this.challengeId = challengeId;
    }

    public String getChallengeDescription() {
        return challengeDescription;
    }

    public void setChallengeDescription(String challengeDescription) {
        this.challengeDescription = challengeDescription;
    }

    public UUID getCompanyId() {
        return companyId;
    }

    public void setCompanyId(UUID companyId) {
        this.companyId = companyId;
    }

    public List<UUID> getParticipants() {
        return participants;
    }

    public void setParticipants(List<UUID> participants) {
        this.participants = participants;
    }

    public List<Rule> getRules() {
        return rules;
    }

    public void setRules(List<Rule> rules) {
        this.rules = rules;
    }

//    public List<HashTag> getHashTagId() {
//        return hashTagId;
//    }

//    public void setHashTagId(List<HashTag> hashTagId) {
//        this.hashTagId = hashTagId;
//    }
}
