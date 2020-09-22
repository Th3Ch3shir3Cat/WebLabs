<?php

namespace App\Controller;

use App\Entity\Cars;
use App\Entity\Category;
use App\Form\CarsType;
use App\Repository\CarsRepository;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\File\UploadedFile;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

/**
 * @Route("/cars")
 */
class CarsController extends AbstractController
{
    /**
     * @Route("/{id}/show", name="cars_index", methods={"GET"})
     * @param CarsRepository $carsRepository
     * @param Category $category
     * @return Response
     */
    public function index(CarsRepository $carsRepository, Category $category): Response
    {
        return $this->render('cars/index.html.twig', [
            'cars' => $carsRepository->findByCategoryId($category->getId()),
        ]);
    }

    /**
     * @Route("/new", name="cars_new", methods={"GET","POST"})
     * @param Request $request
     * @return Response
     */
    public function new(Request $request): Response
    {
        $car = new Cars();
        $form = $this->createForm(CarsType::class, $car);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {

            /** @var UploadedFile $ImgPath*/
            $ImgPath = $form->get('ImagePath')->getData();
            $car->setImagePath($this->getParameter('ImagesDirectory').$ImgPath->getClientOriginalName());

            $entityManager = $this->getDoctrine()->getManager();
            $entityManager->persist($car);
            $entityManager->flush();
            return $this->redirectToRoute('main');
        }

        return $this->render('cars/new.html.twig', [
            'car' => $car,
            'form' => $form->createView(),
        ]);
    }

    /**
     * @Route("/{id}", name="cars_show", methods={"GET"})
     * @param Cars $car
     * @return Response
     */
    public function show(Cars $car): Response
    {
        return $this->render('cars/show.html.twig', [
            'car' => $car,
        ]);
    }

    /**
     * @Route("/{id}/edit", name="cars_edit", methods={"GET","POST"})
     * @param Request $request
     * @param Cars $car
     * @return Response
     */
    public function edit(Request $request, Cars $car): Response
    {
        $form = $this->createForm(CarsType::class, $car);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {

            /** @var UploadedFile $ImgPath*/
            $ImgPath = $form->get('ImagePath')->getData();
            $car->setImagePath($this->getParameter('ImagesDirectory').$ImgPath->getClientOriginalName());

            $this->getDoctrine()->getManager()->flush();

            return $this->redirectToRoute('main');
        }

        return $this->render('cars/edit.html.twig', [
            'car' => $car,
            'form' => $form->createView(),
        ]);
    }

    /**
     * @Route("/{id}", name="cars_delete", methods={"DELETE"})
     * @param Request $request
     * @param Cars $car
     * @return Response
     */
    public function delete(Request $request, Cars $car): Response
    {
        if ($this->isCsrfTokenValid('delete'.$car->getId(), $request->request->get('_token'))) {
            $entityManager = $this->getDoctrine()->getManager();
            $entityManager->remove($car);
            $entityManager->flush();
        }

        return $this->redirectToRoute('main');
    }

    /**
     * @return string
     */
    private function generateUniqueFileName(){
        return m5(uniqid());
    }
}
