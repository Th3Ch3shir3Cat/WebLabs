<?php

namespace App\Form;

use App\Entity\Cars;
use App\Entity\Nadstroika;
use phpDocumentor\Reflection\Types\String_;
use Symfony\Component\Form\AbstractType;
use Symfony\Component\Form\Extension\Core\Type\FileType;
use Symfony\Component\Form\Extension\Core\Type\TextType;
use Symfony\Component\Form\FormBuilderInterface;
use Symfony\Component\OptionsResolver\OptionsResolver;

class CarsType extends AbstractType
{
    public function buildForm(FormBuilderInterface $builder, array $options)
    {
        $builder
            ->add('Name', TextType::class,array('label'=>'Наименование'))
            ->add('ImagePath', FileType::class, array('label' => 'Изображение' ,'data_class' => null))
            ->add('Data_born', TextType::class,array('label'=>'Дата выпуска'))
            ->add('Baza', TextType::class,array('label'=>'База'))
            ->add('Id_nadstroika',null,array('label'=>'Надстройка'))
            ->add('Id_category', null,array('label'=>'Категория'))
            ->add('Id_type', null, array('label'=>'Тип техники'))
        ;
    }

    public function configureOptions(OptionsResolver $resolver)
    {
        $resolver->setDefaults([
            'data_class' => Cars::class,
        ]);
    }
}
