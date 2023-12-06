package ksmart.ks48team02.seller.mapper.settlement;

import ksmart.ks48team02.common.dto.SettlementPrjList;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SelSettlementMapper {


    /**
     * 정산 신청 가능 공고 진열
     * @param sstorecode
     * @return
     */
    public List<SettlementPrjList> getSettPrjListByCode(String sstorecode);

}
