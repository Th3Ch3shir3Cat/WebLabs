<?php

namespace App\Repository;

use App\Entity\Nadstroika;
use Doctrine\Bundle\DoctrineBundle\Repository\ServiceEntityRepository;
use Doctrine\Common\Persistence\ManagerRegistry;

/**
 * @method Nadstroika|null find($id, $lockMode = null, $lockVersion = null)
 * @method Nadstroika|null findOneBy(array $criteria, array $orderBy = null)
 * @method Nadstroika[]    findAll()
 * @method Nadstroika[]    findBy(array $criteria, array $orderBy = null, $limit = null, $offset = null)
 */
class NadstroikaRepository extends ServiceEntityRepository
{
    public function __construct(ManagerRegistry $registry)
    {
        parent::__construct($registry, Nadstroika::class);
    }

    // /**
    //  * @return Nadstroika[] Returns an array of Nadstroika objects
    //  */
    /*
    public function findByExampleField($value)
    {
        return $this->createQueryBuilder('n')
            ->andWhere('n.exampleField = :val')
            ->setParameter('val', $value)
            ->orderBy('n.id', 'ASC')
            ->setMaxResults(10)
            ->getQuery()
            ->getResult()
        ;
    }
    */

    /*
    public function findOneBySomeField($value): ?Nadstroika
    {
        return $this->createQueryBuilder('n')
            ->andWhere('n.exampleField = :val')
            ->setParameter('val', $value)
            ->getQuery()
            ->getOneOrNullResult()
        ;
    }
    */
}
