package com.example.exam.repository;

import com.example.exam.model.Deliver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Optional;

@Repository
public class DeliverRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Deliver addDeliver(Deliver deliver){
        String query = "INSERT INTO delivers values (null,?,?,?,?,?)";
        PreparedStatementCreator preparedStatementCreator = connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, deliver.getContactPersonName());
            preparedStatement.setString(2, deliver.getContactPersonPhone ());
            preparedStatement.setString(3, deliver.getAddress());
            preparedStatement.setString(4, deliver.getPreferredTime());
            preparedStatement.setBoolean(5, deliver.isDelivered());
            return preparedStatement;
        };
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(preparedStatementCreator, generatedKeyHolder);
        deliver.setId(generatedKeyHolder.getKey().intValue());
        return deliver;
    }

   public Boolean updateDeliver(Deliver deliver){
        var id= deliver.getId();
        var query ="update delivers set contactPersonName=?,  contactPersonPhone = ?, address=?, preferredTime=?, delivered=? where id = ?";
        jdbcTemplate.update(query, deliver.getContactPersonName(),  deliver.getContactPersonPhone(), deliver.getAddress(), deliver.getPreferredTime(),deliver.isDelivered(), deliver.getId());
        return true;
    }

    public Optional<Deliver> getDeliverById(int id){
        var query = "SELECT * FROM delivers where id = ?";
        var deliver =  jdbcTemplate.query(query, new BeanPropertyRowMapper<>(Deliver.class), id).stream().findFirst();
        return deliver;
    }


}
