package de.ass73.efile.manager.backend.model;

import lombok.*;

@ToString
@Getter
@Setter
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class FileModel {
    private Long id;
    private String name;
}
