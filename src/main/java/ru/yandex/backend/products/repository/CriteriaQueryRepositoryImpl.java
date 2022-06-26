package ru.yandex.backend.products.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.yandex.backend.products.model.Item;
import ru.yandex.backend.products.model.enums.ShopUnitType;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.time.ZonedDateTime;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class CriteriaQueryRepositoryImpl implements CriteriaQueryRepository {

    private final EntityManager entityManager;

    @Override
    public List<Item> findSalesByDate(ZonedDateTime endDate) {
        ZonedDateTime startDate = endDate.minusDays(1);

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Item> criteriaQuery = criteriaBuilder.createQuery(Item.class);
        Root<Item> root = criteriaQuery.from(Item.class);

        ParameterExpression<ZonedDateTime> dateParameter = criteriaBuilder.parameter(ZonedDateTime.class);
        ParameterExpression<String> typeParameter = criteriaBuilder.parameter(String.class);

        Predicate typePredicate = criteriaBuilder.equal(root.get("itemType").as(String.class), typeParameter);
        Predicate startDatePredicate = criteriaBuilder.greaterThanOrEqualTo(root.get("updateTime").as(ZonedDateTime.class), dateParameter);
        Predicate endDatePredicate = criteriaBuilder.lessThanOrEqualTo(root.get("updateTime").as(ZonedDateTime.class), dateParameter);
        Predicate and = criteriaBuilder.and(typePredicate, startDatePredicate, endDatePredicate);

        criteriaQuery
                .select(root)
                .where(and);

        TypedQuery<Item> typedQuery = entityManager.createQuery(criteriaQuery)
                .setParameter(typeParameter, ShopUnitType.OFFER.name())
                .setParameter(dateParameter, startDate)
                .setParameter(dateParameter, endDate);
        return typedQuery.getResultList();
    }
}



















