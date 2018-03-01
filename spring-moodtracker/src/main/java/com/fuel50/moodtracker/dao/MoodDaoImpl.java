package com.fuel50.moodtracker.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.joda.time.LocalDate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fuel50.moodtracker.model.Mood;

@Repository("moodDao")
@Transactional
public class MoodDaoImpl extends AbstractDao<Integer, Mood> implements MoodDao {

	@Override
	public void saveMood(Mood mood) {
		this.saveOrUpdate(mood);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Mood> findByTrackDate(LocalDate date) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("trackDate", date)).addOrder(Order.asc("id"));
		return (List<Mood>) criteria.list();
	}

}
