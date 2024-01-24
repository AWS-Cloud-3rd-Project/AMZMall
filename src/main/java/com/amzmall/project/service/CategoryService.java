package com.amzmall.project.service;

import com.amzmall.project.model.Category;
import com.amzmall.project.model.CategoryResult;
import com.amzmall.project.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

//    public List<CategoryResult> depthone(int depth){
//        List<CategoryResult> results = categoryRepository.findDepthone(depth).stream().map(CategoryResult::of).collect(Collectors.toList());
//        return results;
//    }
//
//    @Transactional(rollbackFor = Exception.class)
//    public List<CategoryResult> getCategoryList() {
////        System.out.println(1);
////        List<Category> categories = categoryRepository.findAll();
////        System.out.println(2);
//        // Assuming CategoryResult.of(Category) method is available
////        List<CategoryResult> results = categories.stream().map(CategoryResult::of).collect(Collectors.toList());
//
//        List<CategoryResult> results = categoryRepository.findAll().stream().map(CategoryResult::of).collect(Collectors.toList());
//        return results;
//    }
public List<CategoryResult> getTopLevelCategories(int depth) {
    List<Category> topLevelCategories = categoryRepository.findAllByParentIsNull();
    return topLevelCategories.stream()
            .map(CategoryResult::of)
            .collect(Collectors.toList());
}

    public List<CategoryResult> getDepthOneCategories(int depth) {
        List<Category> depthOneCategories = categoryRepository.findAllByDepth(depth);
        return depthOneCategories.stream()
                .map(CategoryResult::of)
                .collect(Collectors.toList());
    }

//    public List<CategoryResult> depthtest(Long parentCategoryId,int targetDepth){
//        List<CategoryResult> results = categoryRepository.findChildrenByDepth(parentCategoryId,targetDepth).stream().map(CategoryResult::of).collect(Collectors.toList());
//        return results;
//    }
}
