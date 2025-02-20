package com.clbee.admin.boardservice.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/**
 * com.clbee.admin.boardservice.domain.posts.PostsId
 * <p>
 * 게시물 엔티티 복합키 클래스
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
 *  2025/02/20    seohan jung       최초 생성
 * </pre>
 */
@Getter
@NoArgsConstructor
@Embeddable
public class PostsId implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 2286680637185590124L;

    /**
     * 게시판 번호
     */
    @Column(columnDefinition = "int(9)")
    private Integer boardNo; // @MapsId("boardNo")로 매핑

    /**
     * 게시물 번호
     */
    @Column(columnDefinition = "int(9)")
    private Integer postsNo;

    /**
     * 빌드 패턴 클래스 생성자
     *
     * @param boardNo 게시판 번호
     * @param postsNo 게시물 번호
     */
    @Builder
    public PostsId(Integer boardNo, Integer postsNo) {
        this.boardNo = boardNo;
        this.postsNo = postsNo;
    }

    /**
     * Returns a hash code value for the object. This method is supported for the benefit of hash tables such as those provided by java.util.HashMap.
     *
     * @return int a hash code value for this object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(boardNo, postsNo);
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
        if (!(object instanceof PostsId)) return false;
        PostsId that = (PostsId) object;
        return Objects.equals(boardNo, that.getBoardNo()) &&
                Objects.equals(postsNo, that.getPostsNo());
    }

    @Override
    public String toString() {
        return this.boardNo+"_"+this.postsNo;
    }
}
