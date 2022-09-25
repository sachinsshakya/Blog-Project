package com.self.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.NamedStoredProcedureQueries;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PostPageableResponse {

    private List<PostDto> posts;
    private int pageNumber;
    private int pageSize;
    private Long totalPosts;
    private int totalPages;
    private boolean lastPage;
}
