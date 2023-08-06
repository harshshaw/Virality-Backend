package com.Virality.socialMedia.Entity.Challenges;

import org.springframework.data.redis.core.RedisHash;

import java.util.UUID;
@RedisHash("Rule")
public class Rule {
    private UUID ruleId ;
    private UUID challengeId;
    private Integer target;

    private Criteria criteria;

    public UUID getRuleId() {
        return ruleId;
    }

    public void setRuleId(UUID ruleId) {
        this.ruleId = ruleId;
    }

    public UUID getChallengeId() {
        return challengeId;
    }

    public void setChallengeId(UUID challengeId) {
        this.challengeId = challengeId;
    }

    public Integer getTarget() {
        return target;
    }

    public void setTarget(Integer target) {
        this.target = target;
    }

    public Criteria getCriteria() {
        return criteria;
    }

    public void setCriteria(Criteria criteria) {
        this.criteria = criteria;
    }


}
