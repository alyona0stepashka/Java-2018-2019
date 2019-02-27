package ShowAbstract;

import Broadcast.Broadcast;
import tv.TV;
//Абстрактная фабрика задаёт интерфейс создания всех доступных типов продуктов, а каждая конкретная реализация фабрики порождает продукты одной из вариаций.
//который позволяет создавать семейства связанных объектов, не привязываясь к конкретным классам создаваемых объектов.

public abstract class Show {
    public abstract void ShowIt(Broadcast br);
}
