package com.disid.restful.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepositoryCustomImpl;

import com.disid.restful.model.Category;
import com.disid.restful.model.Product;
import com.disid.restful.model.QCategory;
import com.mysema.query.BooleanBuilder;
import com.mysema.query.jpa.JPQLQuery;
import com.mysema.query.types.Order;
import com.mysema.query.types.OrderSpecifier;
import com.mysema.query.types.path.NumberPath;

@RooJpaRepositoryCustomImpl(repository = CategoryRepositoryCustom.class)
public class CategoryRepositoryImpl extends QueryDslRepositorySupport {

    CategoryRepositoryImpl() {
	super(Category.class);
    }

    private JPQLQuery getQueryFrom(QCategory qEntity) {
	return from(qEntity);
    }

    public Page<Category> findAllByProduct(Product product, GlobalSearch search, Pageable pageable) {

	NumberPath<Long> idCategory = new NumberPath<Long>(Long.class, "id");
	QCategory category = QCategory.category;
	JPQLQuery query = getQueryFrom(category);
	BooleanBuilder where = new BooleanBuilder();

	if (product != null) {
	    where.and(category.products.contains(product));
	}

	if (search != null) {
	    String txt = search.getText();
	    where.and(category.name.containsIgnoreCase(txt).or(category.description.containsIgnoreCase(txt)));

	}
	query.where(where);

	long totalFound = query.count();
	if (pageable != null) {
	    if (pageable.getSort() != null) {
		for (Sort.Order order : pageable.getSort()) {
		    Order direction = order.isAscending() ? Order.ASC : Order.DESC;

		    switch (order.getProperty()) {
		    case "name":
			query.orderBy(new OrderSpecifier<String>(direction, category.name));
			break;
		    case "description":
			query.orderBy(new OrderSpecifier<String>(direction, category.description));
			break;
		    }
		}
	    }
	    query.offset(pageable.getOffset()).limit(pageable.getPageSize());
	}
	query.orderBy(idCategory.asc());

	List<Category> results = query.list(category);
	return new PageImpl<Category>(results, pageable, totalFound);
    }
}