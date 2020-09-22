<?php

namespace App\Controller;

use App\Entity\Category;
use App\Entity\TypeTechnika;
use App\Form\CategoryType;
use App\Repository\CategoryRepository;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

/**
 * @Route("/category")
 */
class CategoryController extends AbstractController
{
    /**
     * @Route("/{id}/show", name="category_index", methods={"GET"})
     * @param CategoryRepository $categoryRepository
     * @param TypeTechnika $technika
     * @return Response
     */
    public function index(CategoryRepository $categoryRepository, TypeTechnika $technika): Response
    {
        return $this->render('category/index.html.twig', [
            'categories' => $categoryRepository->findByTechnikaId($technika->getId()),
        ]);
    }


    /**
     * @Route("/{id}", name="category_show", methods={"GET"})
     * @param Category $category
     * @return Response
     */
    public function show(Category $category): Response
    {
        return $this->render('category/show.html.twig', [
            'category' => $category,
        ]);
    }




}
