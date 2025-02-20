package com.clbee.admin.boardservice.domain.comment;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import com.clbee.admin.boardservice.domain.posts.PostsId;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/**
 * com.clbee.admin.boardservice.domain.comment.CommentId
 * <p>
 * 댓글 엔티티 복합키 클래스
 *
 * @author seohan jung
 * @version 1.0
 * @since 2025/02/20
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *     수정일        수정자           수정내용
 *  ----------    --------    ---------------------------
 *  2025/02/20   seohan       최초 생성
 * </pre>
 */
@Getter
@NoArgsConstructor
@Embeddable
public class CommentId implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -8263227281325691911L;

    /**
     * 게시물 복합키
     */
    private PostsId postsId; // @MapsId("postsId")로 매핑

    /**
     * 댓글 번호
     */
    @Column(columnDefinition = "int(9)")
    private Integer commentNo;

    /**
     * 빌드 패턴 클래스 생성자
     *
     * @param postsId   게시물 복합키
     * @param commentNo 댓글 번호
     */
    @Builder
    public CommentId(PostsId postsId, Integer commentNo) {
        this.postsId = postsId;
        this.commentNo = commentNo;
    }

    /**
     * Returns a hash code value for the object. This method is supported for the benefit of hash tables such as those provided by java.util.HashMap.
     *
     * @return int a hash code value for this object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(postsId.getBoardNo(), postsId.getPostsNo(), commentNo);
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     *
     * @param   object   the reference object with which to compare.
     * @return  {@code true} if this object is the same as the obj
     */
    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof CommentId)) return false;
        CommentId that = (CommentId) object;
        return Objects.equals(postsId.getBoardNo(), that.getPostsId().getBoardNo()) &&
                Objects.equals(postsId.getPostsNo(), that.getPostsId().getPostsNo()) &&
                Objects.equals(commentNo, that.getCommentNo());
    }

}
