<?php

namespace App\Repository;

use App\Entity\TypeTechnika;
use Doctrine\Bundle\DoctrineBundle\Repository\ServiceEntityRepository;
use Doctrine\Common\Persistence\ManagerRegistry;

/**
 * @method TypeTechnika|null find($id, $lockMode = null, $lockVersion = null)
 * @method TypeTechnika|null findOneBy(array $criteria, array $orderBy = null)
 * @method TypeTechnika[]    findAll()
 * @method TypeTechnika[]    findBy(array $criteria, array $orderBy = null, $limit = null, $offset = null)
 */
class TypeTechnikaRepository extends ServiceEntityRepository
{
    public function __construct(ManagerRegistry $registry)
    {
        parent::__construct($registry, TypeTechnika::class);
    }

    // /**
    //  * @return TypeTechnika[] Returns an array of TypeTechnika objects
    //  */
    /*
    public function findByExampleField($value)
    {
        return $this->createQueryBuilder('t')
            ->andWhere('t.exampleField = :val')
            ->setParameter('val', $value)
            ->orderBy('t.id', 'ASC')
            ->setMaxResults(10)
            ->getQuery()
            ->getResult()
        ;
    }
    */

    /*
    public function findOneBySomeField($value): ?TypeTechnika
    {
        return $this->createQueryBuilder('t')
            ->andWhere('t.exampleField = :val')
            ->setParameter('val', $value)
            ->getQuery()
            ->getOneOrNullResult()
        ;
    }
    */
}
