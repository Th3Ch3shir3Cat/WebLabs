<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * @ORM\Entity(repositoryClass="App\Repository\CarsRepository")
 */
class Cars
{
    /**
     * @ORM\Id()
     * @ORM\GeneratedValue()
     * @ORM\Column(type="integer")
     */
    private $id;

    /**
     * @ORM\Column(type="string", length=255)
     */
    private $Name;

    /**
     * @ORM\Column(type="string", length=255, nullable=true)
     */
    private $ImagePath;

    /**
     * @ORM\Column(type="string", length=255)
     */
    private $Data_born;

    /**
     * @ORM\Column(type="string", length=255)
     */
    private $Baza;

    /**
     * @ORM\ManyToOne(targetEntity="App\Entity\Nadstroika", inversedBy="cars")
     */
    private $Id_nadstroika;

    /**
     * @ORM\ManyToOne(targetEntity="App\Entity\Category", inversedBy="cars")
     */
    private $Id_category;

    /**
     * @ORM\ManyToOne(targetEntity="App\Entity\TypeTechnika", inversedBy="cars")
     */
    private $Id_type;

    public function getId(): ?int
    {
        return $this->id;
    }

    public function getName(): ?string
    {
        return $this->Name;
    }

    public function setName(string $Name): self
    {
        $this->Name = $Name;

        return $this;
    }

    public function getImagePath(): ?string
    {
        return $this->ImagePath;
    }

    public function setImagePath(?string $ImagePath): self
    {
        $this->ImagePath = $ImagePath;

        return $this;
    }

    public function getDataBorn(): ?string
    {
        return $this->Data_born;
    }

    public function setDataBorn(string $Data_born): self
    {
        $this->Data_born = $Data_born;

        return $this;
    }

    public function getBaza(): ?string
    {
        return $this->Baza;
    }

    public function setBaza(string $Baza): self
    {
        $this->Baza = $Baza;

        return $this;
    }

    public function getIdNadstroika(): ?Nadstroika
    {
        return $this->Id_nadstroika;
    }

    public function setIdNadstroika(?Nadstroika $Id_nadstroika): self
    {
        $this->Id_nadstroika = $Id_nadstroika;

        return $this;
    }

    public function getIdCategory(): ?Category
    {
        return $this->Id_category;
    }

    public function setIdCategory(?Category $Id_category): self
    {
        $this->Id_category = $Id_category;

        return $this;
    }

    public function getIdType(): ?TypeTechnika
    {
        return $this->Id_type;
    }

    public function setIdType(?TypeTechnika $Id_type): self
    {
        $this->Id_type = $Id_type;

        return $this;
    }

    public function __toString()
    {
        // TODO: Implement __toString() method.
        return $this->Name;
    }
}
