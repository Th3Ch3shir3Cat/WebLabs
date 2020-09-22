<?php

declare(strict_types=1);

namespace DoctrineMigrations;

use Doctrine\DBAL\Schema\Schema;
use Doctrine\Migrations\AbstractMigration;

/**
 * Auto-generated Migration: Please modify to your needs!
 */
final class Version20200311080926 extends AbstractMigration
{
    public function getDescription() : string
    {
        return '';
    }

    public function up(Schema $schema) : void
    {
        // this up() migration is auto-generated, please modify it to your needs
        $this->abortIf($this->connection->getDatabasePlatform()->getName() !== 'mysql', 'Migration can only be executed safely on \'mysql\'.');

        $this->addSql('CREATE TABLE cars (id INT AUTO_INCREMENT NOT NULL, id_nadstroika_id INT DEFAULT NULL, id_category_id INT DEFAULT NULL, id_type_id INT DEFAULT NULL, name VARCHAR(255) NOT NULL, image_path VARCHAR(255) DEFAULT NULL, data_born VARCHAR(255) NOT NULL, baza VARCHAR(255) NOT NULL, INDEX IDX_95C71D14EE8A16FD (id_nadstroika_id), INDEX IDX_95C71D14A545015 (id_category_id), INDEX IDX_95C71D141BD125E3 (id_type_id), PRIMARY KEY(id)) DEFAULT CHARACTER SET utf8mb4 COLLATE `utf8mb4_unicode_ci` ENGINE = InnoDB');
        $this->addSql('CREATE TABLE category (id INT AUTO_INCREMENT NOT NULL, id_type_id INT NOT NULL, name VARCHAR(255) NOT NULL, image_path VARCHAR(255) DEFAULT NULL, INDEX IDX_64C19C11BD125E3 (id_type_id), PRIMARY KEY(id)) DEFAULT CHARACTER SET utf8mb4 COLLATE `utf8mb4_unicode_ci` ENGINE = InnoDB');
        $this->addSql('CREATE TABLE nadstroika (id INT AUTO_INCREMENT NOT NULL, name VARCHAR(255) NOT NULL, PRIMARY KEY(id)) DEFAULT CHARACTER SET utf8mb4 COLLATE `utf8mb4_unicode_ci` ENGINE = InnoDB');
        $this->addSql('CREATE TABLE type_technika (id INT AUTO_INCREMENT NOT NULL, name VARCHAR(255) DEFAULT NULL, image_path VARCHAR(255) DEFAULT NULL, PRIMARY KEY(id)) DEFAULT CHARACTER SET utf8mb4 COLLATE `utf8mb4_unicode_ci` ENGINE = InnoDB');
        $this->addSql('ALTER TABLE cars ADD CONSTRAINT FK_95C71D14EE8A16FD FOREIGN KEY (id_nadstroika_id) REFERENCES nadstroika (id)');
        $this->addSql('ALTER TABLE cars ADD CONSTRAINT FK_95C71D14A545015 FOREIGN KEY (id_category_id) REFERENCES category (id)');
        $this->addSql('ALTER TABLE cars ADD CONSTRAINT FK_95C71D141BD125E3 FOREIGN KEY (id_type_id) REFERENCES type_technika (id)');
        $this->addSql('ALTER TABLE category ADD CONSTRAINT FK_64C19C11BD125E3 FOREIGN KEY (id_type_id) REFERENCES type_technika (id)');
    }

    public function down(Schema $schema) : void
    {
        // this down() migration is auto-generated, please modify it to your needs
        $this->abortIf($this->connection->getDatabasePlatform()->getName() !== 'mysql', 'Migration can only be executed safely on \'mysql\'.');

        $this->addSql('ALTER TABLE cars DROP FOREIGN KEY FK_95C71D14A545015');
        $this->addSql('ALTER TABLE cars DROP FOREIGN KEY FK_95C71D14EE8A16FD');
        $this->addSql('ALTER TABLE cars DROP FOREIGN KEY FK_95C71D141BD125E3');
        $this->addSql('ALTER TABLE category DROP FOREIGN KEY FK_64C19C11BD125E3');
        $this->addSql('DROP TABLE cars');
        $this->addSql('DROP TABLE category');
        $this->addSql('DROP TABLE nadstroika');
        $this->addSql('DROP TABLE type_technika');
    }
}
