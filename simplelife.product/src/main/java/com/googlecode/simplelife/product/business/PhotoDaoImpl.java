package com.googlecode.simplelife.product.business;

import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.googlecode.simplelife.product.dao.HibernateDao;

public class PhotoDaoImpl extends HibernateDao<Photo, String> implements
		PhotoDao {

	@Override
	public void delete(final Product product) {
		this.getHibernateTemplate().execute(new HibernateCallback() {

			@Override
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session
						.createQuery("delete from Photo p where p.product=?");
				query.setParameter(0, product);
				return query.executeUpdate();
			}

		});
	}

	@Override
	public Photo findByProductId(final String id) {
		return (Photo) this.getHibernateTemplate().execute(new HibernateCallback() {

			@Override
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session
						.createQuery("from Photo p where p.product.id=?");
				query.setParameter(0, id);
				return query.uniqueResult();
			}

		});
	}

}
