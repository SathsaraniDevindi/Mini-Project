package com.example.shoppingsite.Repository;

import com.example.shoppingsite.Model.Category;
import com.example.shoppingsite.Model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * The interface Category repository.
 */
@Repository
public interface CategoryRepository extends MongoRepository<Category,String> {

}
