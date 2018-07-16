package Dao.Entity.Bean;

import Util.Verification.Note;
import lombok.Data;

@Data
public class MaterialBasic {
    private int matId;
    @Note(name = "建材名称")
    private String matName;
    @Note(name = "建材总数", type = 3)
    private int matCount;
    private int matOut;
    private int matResidue;
    @Note(name = "单位")
    private String matUnit;
}
