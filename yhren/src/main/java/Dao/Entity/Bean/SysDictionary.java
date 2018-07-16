package Dao.Entity.Bean;

import lombok.Data;

@Data
public class SysDictionary {
    private Integer dicId;
    private Integer dicType;
    private Integer dicKey;
    private String dicValue;
    private String dicUnit;
}
