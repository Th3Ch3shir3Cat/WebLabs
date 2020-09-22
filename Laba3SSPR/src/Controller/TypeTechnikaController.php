<?php

namespace App\Controller;

use App\Entity\TypeTechnika;
use App\Form\TypeTechnikaType;
use App\Repository\TypeTechnikaRepository;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

/**
 * @Route("/type/technika")
 */
class TypeTechnikaController extends AbstractController
{
    /**
     * @Route("/", name="type_technika_index", methods={"GET"})
     */
    public function index(TypeTechnikaRepository $typeTechnikaRepository): Response
    {
        return $this->render('type_technika/index.html.twig', [
            'type_technikas' => $typeTechnikaRepository->findAll(),
        ]);
    }


    /**
     * @Route("/{id}", name="type_technika_show", methods={"GET"})
     */
    public function show(TypeTechnika $typeTechnika): Response
    {
        return $this->render('type_technika/show.html.twig', [
            'type_technika' => $typeTechnika,
        ]);
    }

}
