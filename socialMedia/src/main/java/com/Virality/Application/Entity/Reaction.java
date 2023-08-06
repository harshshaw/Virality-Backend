package com.Virality.Application.Entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.UUID;

@Entity
public class Reaction {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID reactionId;

    @CreationTimestamp
    private Date createdDate;

    @UpdateTimestamp
    private Date updatedDate;

    @Enumerated(EnumType.STRING)
    private SourceType sourceType;

    @Enumerated(EnumType.STRING)
    private ReactionType reactionType;

    public ReactionType getReactionType() {
        return reactionType;
    }

    public void setReactionType(ReactionType reactionType) {
        this.reactionType = reactionType;
    }

    public UUID getReactionId() {
        return reactionId;
    }

    public void setReactionId(UUID reactionId) {
        this.reactionId = reactionId;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public SourceType getSourceType() {
        return sourceType;
    }

    public void setSourceType(SourceType sourceType) {
        this.sourceType = sourceType;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne
    @JoinColumn(referencedColumnName = "postId")
    private Post post;

    @ManyToOne
    @JoinColumn(referencedColumnName = "commentId")
    private Comment comment;

    @ManyToOne
    @JoinColumn(referencedColumnName = "userId")
    private User user;

}
