package io.github.seondongpyo.mybatis.mapper;

import io.github.seondongpyo.mybatis.domain.suit.Client;
import io.github.seondongpyo.mybatis.domain.suit.Lawsuit;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@MybatisTest
class LawsuitMapperTest {

    @Autowired
    private LawsuitMapper lawsuitMapper;

    @DisplayName("외래 키 연관관계가 아니더라도 resultMap으로 1:N 조회가 가능하다")
    @Test
    void findById() {
        Lawsuit lawsuit = lawsuitMapper.findById(1L);
        assertThat(lawsuit.getClients()).hasSize(2);
    }
}
